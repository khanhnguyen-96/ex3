package banana.mybk.Database;

public class Subject {
    String code;
    String name;
    long credit;
    long credit_fee;
    long fee;
    String group;
    long date;
    String lesson;
    String room;
    String week;
    String day;
    String time;
    String examRoom;

    public Subject(String code, String name, long credit, long credit_fee, long fee, String group,
                   long date, String lesson, String room, String week, String day, String time, String examRoom) {
        super();
        this.code = code;
        this.name = name;
        this.credit = credit;
        this.credit_fee = credit_fee;
        this.fee = fee;
        this.group = group;
        this.date = date;
        this.lesson = lesson;
        this.room = room;
        this.week = week;
        this.day = day;
        this.time = time;
        this.examRoom = examRoom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCredit() {
        return credit;
    }

    public void setCredit(long credit) {
        this.credit = credit;
    }

    public long getCreditFee() {
        return credit_fee;
    }

    public void setCreditFee(long credit_fee) {
        this.credit_fee = credit_fee;
    }

    public long getFee() {
        return fee;
    }

    public void setFee(long fee) {
        this.fee = fee;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.room = week;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getExamRoom() {
        return examRoom;
    }

    public void setExamRoom(String examRoom) {
        this.examRoom = examRoom;
    }

}
