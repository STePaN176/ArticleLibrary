package entity;

import java.util.Date;


public class ScienceJournal {

    public int id;
    public String journal_name;
    public Date create_ts;

    public ScienceJournal() {

    }

    public ScienceJournal(int id, String journal_name) {
        this.id = id;
        this.journal_name = journal_name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJournal_name() {
        return journal_name;
    }

    public void setJournal_name(String journal_name) {
        this.journal_name = journal_name;
    }

    public Date getCreate_ts() {
        return create_ts;
    }

    public void setCreate_ts(Date create_ts) {
        this.create_ts = create_ts;
    }

    // Выводим информацию по продукту
    @Override
    public String toString() {
        return String.format("%s",this.journal_name);
    }
}
