public class Contact {
    private String name;
    private String surname;
    private String phone;
    private String birthday;

    public Contact(String name, String surname, String phone, String birthday) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.birthday = birthday;
    }

    public String getName() {
        String s1 = String.valueOf(name.charAt(0)).toUpperCase();
        return s1 + name.substring(1);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        String s1 = String.valueOf(surname.charAt(0)).toUpperCase();
        return s1 + surname.substring(1);
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
