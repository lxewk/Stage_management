package nl.kortekaas.Stagemanagement.domain;

public class Item {

    private Role managerRole;
    private String itemName;
    private Department section;
    private PositionOnStage preset;
    private Todo todo;
    private Risk risk;

    public Item(Role managerRole, String itemName, Department section ) {
        this.managerRole = managerRole;
        this.itemName = itemName;
        this.section = section;
        this.preset = preset;
        Item todoItem = new Item(managerRole, itemName, section);
        this.todo = new Todo(todoItem);
        this.risk = risk;
    }

    public void addPhoto(){
        System.out.println("here should be a picture");
    }

    public void addVideo(){
        System.out.println("here should be a video");
    }

    public Role getManagerRole() {
        return managerRole;
    }

    public void setManagerRole(Role managerRole) {
        this.managerRole = managerRole;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Department getSection() {
        return section;
    }

    public void setSection(Department section) {
        this.section = section;
    }

    public PositionOnStage getPreset() {
        return preset;
    }

    public void setPreset(PositionOnStage preset) {
        this.preset = preset;
    }

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    public Risk getRisk() {
        return risk;
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
    }
}
