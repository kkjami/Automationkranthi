package sp;

//POJO or model or bean
public class Employee {
    int eid;
    String name;
    Address addr;

    public Employee(int eid, String name) {
        this.eid = eid;
        this.name = name;
    }

    //constructor
    public Employee() {
        System.out.println("--constro");
    }
//parameterised constructor
    public Employee( Address addr) {
        this.addr = addr;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddr() {
        return addr;
    }
//Setter Injection
    public void setAddr(Address addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }

    public void myInit() {
System.out.println("in my init");
    }

    public void myDestroy() {
        System.out.println("in my destroy");
    }
}
