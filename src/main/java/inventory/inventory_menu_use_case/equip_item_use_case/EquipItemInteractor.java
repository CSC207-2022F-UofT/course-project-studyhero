package inventory.inventory_menu_use_case.equip_item_use_case;


import stats.entities.StatsUser;
import errors.usecases.ErrorOutputBoundary;
import errors.usecases.ErrorPresenter;
import filesaver.usecases.file_checker.ValidStats;
import filesaver.usecases.save_game.StatSave;

import java.util.Map;

public class EquipItemInteractor implements EquipItemInputBoundary{
    final EquipItemDsGateway dsGateway;
    final EquipItemOutputBoundary outputBoundary;



    /**
     *
     * @param dsGateway an interface that communicates with the inventory data
     * @param outputBoundary an interface that communicates with output data
     */
    public EquipItemInteractor(EquipItemDsGateway dsGateway, EquipItemOutputBoundary outputBoundary) {
        this.dsGateway = dsGateway;
        this.outputBoundary = outputBoundary;
    }


    /**
     * delete the item corresponding to the id in the inventory
     * @param requestModel the id of the inventory item in inventory
     * @return a response model that contains the id and the name of the item
     * that has been equipped by the player from the inventory
     */
    @Override
    public EquipItemResponseModel equip(EquipItemRequestModel requestModel) {
        if(!dsGateway.itemExist(requestModel.getId())){
            return outputBoundary.prepareFailView("Item does not exist on the slot");
        }

        if(!dsGateway.itemEquipable(requestModel.getId())){
            return outputBoundary.prepareFailView("The item that you select is not equipable");
        }

        EquipItemDsRequestModel name = dsGateway.getEquipName(requestModel.getId());
        EquipItemResponseModel equipItemResponseModel = new EquipItemResponseModel(name.getName(),
                requestModel.getId());

        int diff = dsGateway.equipItem(requestModel.getId());

        ErrorOutputBoundary errorPresenter;
        errorPresenter = new ErrorPresenter();
        ValidStats stats = new ValidStats("stats.csv", errorPresenter);
        Map<String, Integer> statsMap = stats.load();
        StatsUser intermediateUser = new StatsUser(statsMap);

        if(name.getType().equals("Weapon")){
            intermediateUser.updateBaselineDamage(diff);
        }else{
            intermediateUser.updateDefence(diff);
        }

        StatSave saver = new StatSave(intermediateUser.getUserStats(), errorPresenter);
        saver.save("stats.csv");

        return outputBoundary.prepareSuccessView(equipItemResponseModel);
    }
}
