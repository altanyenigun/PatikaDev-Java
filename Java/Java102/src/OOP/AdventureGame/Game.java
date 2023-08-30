package OOP.AdventureGame;

import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Macera Oyununa Hoşgeldiniz !");
        System.out.println("Lütfen bir isim giriniz : ");
        //String playerName = input.nextLine();
        Player player = new Player("Mustafa");
        System.out.println("Sayın " + player.getName() + " bu karanlık ve sisli adaya Hoşgeldiniz !! Burada yaşananların hepsi gerçek!");
        System.out.println("Lütfen bir karakter seçiniz ");
        player.selectChar();

        Location location=null;

        while(true){
            player.printInfo();
            System.out.println();
            System.out.println("######## Bölgeler ########");
            System.out.println();
            System.out.println("1- Güvenli Ev --> Burasi sizin için güvenli bir ev, düşman yoktur !");
            System.out.println("2- Mağaza --> Silah veya Zırh satın alabilirsiniz !");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 1:
                    location = new SafeHouse(player); //buradaki this üretilen Player nesnesini kastediyor.
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if(!location.onLocation()){
                System.out.println("GAME OVER!");
                break;
            }
        }
    }
}