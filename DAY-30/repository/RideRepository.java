package repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Ride;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepository
{
    private static final String FILE_PATH = "resources/rides.json";
    private final Gson gson = new Gson();
    private Map<String, List<Ride>> rideMap;

    public RideRepository() {
        this.rideMap = loadFromJson();
    }

    public void addRides(String userId, List<Ride> rides) {
        rideMap.put(userId, rides);
        saveToJson();
    }


    public Ride[] getRides(String userId) {
        return rideMap.get(userId).toArray(new Ride[0]);
    }

    /* ---------------- JSON HANDLING ---------------- */

    private void saveToJson() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(rideMap, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, List<Ride>> loadFromJson() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new HashMap<>();
        }

        try (Reader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<Map<String, List<Ride>>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }
}
