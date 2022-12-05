package inventory_menu.inventory_menu_use_case.display_player_inventory_use_case;

/**
 * This class is incomplete
 */
public interface PlayerDisplayInventoryOutputBoundary {
     /**
      *
      * @param dsRequestModel is the iterator that will be used to access inventory list
      * @return inventory information using arraylist
      */
     PlayerDisplayInventoryResponseModel prepareInventoryView(PlayerDisplayInventoryDsRequestModel dsRequestModel);
}
