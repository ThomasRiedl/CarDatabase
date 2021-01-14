package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CarDatabase
{
    private HashMap<String, Vehicle> db = new HashMap();

    //Hilfe von Klassenkameraden weil die Funktionen der MagicGenerator Klasse bei meinen Lösungen static sein müssten und ich keine andere Lösung gefunden habe
    public CarDatabase()
    {
        MagicGenerator magicGenerator = new MagicGenerator();
        for(int i = 0; i < 1000; i++)
        {
            String manufacturer = magicGenerator.getRandomManufacturer();
            String licencePlate = magicGenerator.getRandomLicencePlate();
            Vehicle v = new Vehicle(magicGenerator.getRandomColor(),magicGenerator.getRandomName(),magicGenerator.getRandomModel(manufacturer),manufacturer,licencePlate);
            db.put(licencePlate,v);
            System.out.println("created vehicle with license plate" + v.getLicensePlate());
        }
        this.db = db;
    }

    public ArrayList<Vehicle> search(String text)
    {
        ArrayList<Vehicle> filteredList=new ArrayList<>();

        for (Map.Entry entry:db.entrySet()) {
            if (entry.getKey().toString().contains(text))
                filteredList.add(db.get(entry.getKey()));
        }
        return filteredList;
    }

    public Vehicle exactSearch(String text) {
        if (db.get(text) != null)
        {
            return db.get(text.toUpperCase());
        }
        else
        {
            return null;
        }
    }
}