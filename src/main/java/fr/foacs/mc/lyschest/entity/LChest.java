package fr.foacs.mc.lyschest.entity;

public class LChest {

  private final String id;
  private String name;

  public LChest(String id) {
    this.id = id;
  }

  public LChest(String id, String name) {
    this.id = id;
    this.name = name;
  }


  public String getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

}
