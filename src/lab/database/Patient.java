package lab.database;

public class Patient {
    public String fullname;
    public String login;
    public String pwd;
    public String guid;
    public String email;
    public String socialSecNumber;
    public String ein;
    public String socialType;
    public String phone;
    public String passport_s;
    public String passport_n;
    public String birthdate;
    public String id;
    public String country;
    public String insuranceName;
    public String insuranceAddress;
    public String insuranceInn;
    public String ipAddress;
    public String insuranceP;
    public String insuranceBik;
    public String ua;

    public Patient(String fullname, String login, String pwd, String guid, String email, String socialSecNumber,
                   String ein, String socialType, String phone, String passport_s, String passport_n, String birthdate,
                   String id, String country, String insuranceName, String insuranceAddress, String insuranceInn,
                   String ipAddress, String insuranceP, String insuranceBik, String ua) {
        this.fullname = fullname;
        this.login = login;
        this.pwd = pwd;
        this.guid = guid;
        this.email = email;
        this.socialSecNumber = socialSecNumber;
        this.ein = ein;
        this.socialType = socialType;
        this.phone = phone;
        this.passport_s = passport_s;
        this.passport_n = passport_n;
        this.birthdate = birthdate;
        this.id = id;
        this.country = country;
        this.insuranceName = insuranceName;
        this.insuranceAddress = insuranceAddress;
        this.insuranceInn = insuranceInn;
        this.ipAddress = ipAddress;
        this.insuranceP = insuranceP;
        this.insuranceBik = insuranceBik;
        this.ua = ua;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocialSecNumber() {
        return socialSecNumber;
    }

    public void setSocialSecNumber(String socialSecNumber) {
        this.socialSecNumber = socialSecNumber;
    }

    public String getEin() {
        return ein;
    }

    public void setEin(String ein) {
        this.ein = ein;
    }

    public String getSocialType() {
        return socialType;
    }

    public void setSocialType(String socialType) {
        this.socialType = socialType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassport_s() {
        return passport_s;
    }

    public void setPassport_s(String passport_s) {
        this.passport_s = passport_s;
    }

    public String getPassport_n() {
        return passport_n;
    }

    public void setPassport_n(String passport_n) {
        this.passport_n = passport_n;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getInsuranceAddress() {
        return insuranceAddress;
    }

    public void setInsuranceAddress(String insuranceAddress) {
        this.insuranceAddress = insuranceAddress;
    }

    public String getInsuranceInn() {
        return insuranceInn;
    }

    public void setInsuranceInn(String insuranceInn) {
        this.insuranceInn = insuranceInn;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getInsuranceP() {
        return insuranceP;
    }

    public void setInsuranceP(String insuranceP) {
        this.insuranceP = insuranceP;
    }

    public String getInsuranceBik() {
        return insuranceBik;
    }

    public void setInsuranceBik(String insuranceBik) {
        this.insuranceBik = insuranceBik;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }
}
