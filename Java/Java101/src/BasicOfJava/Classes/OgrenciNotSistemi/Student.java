package BasicOfJava.Classes.OgrenciNotSistemi;

public class Student {
    Course c1;
    Course c2;
    Course c3;
    String name;
    String stuNo;
    String classes;
    double avarage;
    boolean isPass;

    Student(String name,String stuNo,String classes,Course c1,Course c2,Course c3){
        this.name=name;
        this.stuNo=stuNo;
        this.classes=classes;
        this.c1=c1;
        this.c2=c2;
        this.c3=c3;
        this.avarage=0;
        this.isPass=false;
    }

    void addBulkExamNote(int note1, int note2, int note3){
        if(note1>=0 && note1<=100)
            this.c1.note=note1;
        if(note2>=0 && note2<=100)
            this.c2.note=note2;
        if(note3>=0 && note3<=100)
            this.c3.note=note3;
    }

    void addBulkVerbalNote(int verbalNote1, int verbalNote2, int verbalNote3){
        if(verbalNote1>=0 && verbalNote1<=100)
            this.c1.verbalNote=verbalNote1;
        if(verbalNote2>=0 && verbalNote2<=100)
            this.c2.verbalNote=verbalNote2;
        if(verbalNote3>=0 && verbalNote3<=100)
            this.c3.verbalNote=verbalNote3;
    }

    void isPass(){
        System.out.println("=========");
        this.avarage = ((this.c1.note*0.8 + (this.c1.verbalNote * 0.2)) + (this.c2.note*0.7 + (this.c2.verbalNote * 0.3)) + (this.c3.note*0.6 + (this.c3.verbalNote * 0.4))) / 3.0;

        if(this.avarage>=55){
            System.out.println("Sınıfı başarıyla geçtiniz");
            this.isPass=true;
        }else{
            System.out.println("Sınıfta kaldınız");
            this.isPass=false;
        }

        printNote();
    }

    void printNote(){
        System.out.println(this.c1.name + " Notu \t:"+this.c1.note);
        System.out.println(this.c2.name + " Notu \t:"+this.c2.note);
        System.out.println(this.c3.name + " Notu \t:"+this.c3.note);
        System.out.println("Ortalamanız : " + this.avarage);
    }
}
