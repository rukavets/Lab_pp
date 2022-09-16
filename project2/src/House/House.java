package House;

public class House {
    private int id, apart_number, square, floor, room_number;
    private String street;
    public House(int id, int apart_number, int square, int floor, int room_number, String street){
        this.id=id;
        this.apart_number=apart_number;
        this.square=square;
        this.floor=floor;
        this.room_number=room_number;
        this.street=street;
    }

    public int getRoom_number(){
        return room_number;
    }
    public int getFloor(){
        return floor;
    }
    public int getSquare(){
        return square;
    }
    public String toString() {
        return(String.valueOf(id)+"."+ " Номер квартири: "+ apart_number+"\n  Площа: "+square+"\n  Поверх: "+floor+"\n  Кількість кімнат: "+room_number+"\n  Вулиця: "+street);
    }
}
