package entity;

import java.util.Date;


public class MethodAnalysis {

    public int id;

    public String methodAnalysisName;
    public Date create_ts;

    public MethodAnalysis() {

    }

    public MethodAnalysis(int id, String methodAnalysisName) {
        this.id = id;
        this.methodAnalysisName = methodAnalysisName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMethodAnalysisName() {
        return methodAnalysisName;
    }

    public void setMethodAnalysisName(String methodAnalysisName) {
        this.methodAnalysisName = methodAnalysisName;
    }

    public Date getCreate_ts() {
        return create_ts;
    }

    public void setCreate_ts(Date create_ts) {
        this.create_ts = create_ts;
    }

    @Override
    public String toString() {
        return String.format("%s",this.methodAnalysisName);
    }
}
