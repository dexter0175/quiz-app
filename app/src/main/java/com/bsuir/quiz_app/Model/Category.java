package com.bsuir.quiz_app.Model;


public enum Category{
    MUSIC(12),
    BOOKS(10),
    FILMS(11),
    TELEVISION(14),
    GAMES(15),
    MATHEMATICS(19),
    COMPUTER(18),
    GENERAL(9),
    SPORTS(21),
    ART(25),
    ANIMALS(27),
    POLITICS(24),
    ANIME(31);

    public int id;

    Category(int id) {
        this.id = id;
    }
}
//import java.util.ArrayList;
//import java.util.List;
//
//public class Category {
//    private int id;
//    private String name;
//    private String image;
//
//    public Category(int id, String name, String image) {
//        this.id = id;
//        this.name = name;
//        this.image = image;
//    }
//
//    public Category(int id, String name) {
//        this.id = id;
//        this.name = name;
//        this.image = "default";
//    }
//
//    public static List<Category> getDefault(){
//        List<Category> categories = new ArrayList<Category>();
//        //categories;
//        categories.add(new Category(123,"Music", "My image"));
//        categories.add(new Category(124,"Not music", "My image"));
//        categories.add(new Category(125,"Games", "My image"));
//        categories.add(new Category(126,"History", "My image"));
//        categories.add(new Category(123,"Music", "My image"));
//        categories.add(new Category(124,"Not music", "My image"));
//        categories.add(new Category(125,"Games", "My image"));
//        categories.add(new Category(126,"History", "My image"));
//        categories.add(new Category(123,"Music", "My image"));
//        categories.add(new Category(124,"Not music", "My image"));
//        categories.add(new Category(125,"Games", "My image"));
//        categories.add(new Category(126,"History", "My image"));
//        categories.add(new Category(123,"Music", "My image"));
//        categories.add(new Category(124,"Not music", "My image"));
//        categories.add(new Category(125,"Games", "My image"));
//        categories.add(new Category(126,"History", "My image"));
//
//        return categories;
//    }
//}
