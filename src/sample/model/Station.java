package sample.model;

import sample.model.base.BaseModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Station {


    private static final Station instance = new Station();

    private Map<String, BaseModel> list = new HashMap<String, BaseModel>();

    private Station(){}

    public Map<String, BaseModel> getList() {
        return list;
    }



    public static Station getInstance() {
        return instance;
    }

}
