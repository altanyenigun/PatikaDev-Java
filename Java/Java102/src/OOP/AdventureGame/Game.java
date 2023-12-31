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
        System.out.println("------------------------------------------------");
        player.selectChar();

        Location location=null;
        boolean isAllAwardClaimed = false;

        while(true){
            System.out.println();
            System.out.println("----------------");
            player.printInfo();
            System.out.println("----------------");
            System.out.println();
            System.out.println("######## Bölgeler ########");
            System.out.println();
            System.out.println("1- Güvenli Ev --> Burasi sizin için güvenli bir ev, düşman yoktur !");
            System.out.println("2- Eşya Dükkanı --> Silah veya Zırh satın alabilirsiniz !");
            System.out.println("3- Mağara --> Ödül : <Yemek>, dikkatli ol zombi çıkabilir !");
            System.out.println("4- Orman --> Ödül : <Odun>, dikkatli ol vampir çıkabilir !");
            System.out.println("5- Nehir --> Ödül : <Su>, dikkatli ol ayı çıkabilir !");
            System.out.println("6- Maden --> Ödül : <Silah> || <Zırh> || <Para>, dikkatli ol yılan çıkabilir !");
            System.out.println("0- Çıkış Yap --> Oyunu Sonlandır");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 0:
                    location = null;
                    break;
                case 1:
                    if(player.getInventory().isWater() && player.getInventory().isFood() && player.getInventory().isFirewood()){
                        isAllAwardClaimed = true;
                        break;
                    }
                    location = new SafeHouse(player); //buradaki this üretilen Player nesnesini kastediyor.
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    if(player.getInventory().isFood()){
                        System.out.println("\nBu bölgeyi zaten temizleyip, ödülü aldın !");
                        continue;
                    }
                    location = new Cave(player);
                    break;
                case 4:
                    if(player.getInventory().isFirewood()){
                        System.out.println("\nBu bölgeyi zaten temizleyip, ödülü aldın !");
                        continue;
                    }
                    location = new Forest(player);
                    break;
                case 5:
                    if(player.getInventory().isWater()){
                        System.out.println("\nBu bölgeyi zaten temizleyip, ödülü aldın !");
                        continue;
                    }
                    location = new River(player);
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz !");
            }
            if(isAllAwardClaimed){
                System.out.println(player.getName() + " Tebrikler Oyunu Kazandın!");
                break;
            }
            if(location == null){
                System.out.println("Bu karanlık ve sisli adadan çabuk vazgeçtin !");
                break;
            }
            if(!location.onLocation()){
                System.out.println("GAME OVER!");
                break;
            }
        }
    }
}
