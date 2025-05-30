package OtherProjects.Lab03.OtherProjects.Lab02;

import OtherProjects.Lab04.OtherProjects.Lab02.DigitalVideoDisc;

public class TestPassingParameter {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        OtherProjects.Lab04.OtherProjects.Lab02.DigitalVideoDisc jungleDVD = new OtherProjects.Lab04.OtherProjects.Lab02.DigitalVideoDisc("Jungle");
        OtherProjects.Lab04.OtherProjects.Lab02.DigitalVideoDisc cinderellaDVD = new OtherProjects.Lab04.OtherProjects.Lab02.DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(OtherProjects.Lab04.OtherProjects.Lab02.DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
