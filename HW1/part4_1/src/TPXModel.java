/**
 *  Model class of plane
 */

public class TPXModel extends TAIFactory{

    TPXModel(){}
    /**
     * selected plane model is returned
     * @param typeOfModel plane types
     * @return created model is returned.
     */
    @Override
    Plane createPlane(String typeOfModel) {
        if (typeOfModel.equals("TPX100")) {
            return new TPX100();
        } else if (typeOfModel.equals("TPX200")) {
            return new TPX200();
        } else if (typeOfModel.equals("TPX300")) {
            return new TPX300();
        }else return null;
    }
}