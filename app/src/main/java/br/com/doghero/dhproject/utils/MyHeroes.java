package br.com.doghero.dhproject.utils;

import com.google.gson.Gson;
import br.com.doghero.dhproject.model.DataModel;

public class MyHeroes {

    public static DataModel build(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, DataModel.class);
    }
}
