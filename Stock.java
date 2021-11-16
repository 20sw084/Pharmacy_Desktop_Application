package Pharamacy_Management_System;

public class Stock {
    private int id;
    private String name;
    private String type;
    private String company;
    private int qty;
    private float price;
    private String mfgdate;
    private String expdate;
    private int weight;
    Stock(int id,String name,String type,String company,int qty,float price,String mfgdate,String expdate,int weight){ 
        this.id=id;
        this.name=name;
        this.type=type;
        this.company=company;
        this.qty=qty;
        this.price=price;
        this.mfgdate=mfgdate;
        this.expdate=expdate;
        this.weight=weight;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public String getCompany(){
        return company;
    }
    public int getQty(){
        return qty;
    }
    public float getMedicinePricePerUnit(){
        return price;
    }
    public String getMfgDate(){
        return mfgdate;
    }
    public String getExpDate(){
        return expdate;
    }
    public int getWeight(){
        return weight;
    }
}