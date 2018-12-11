package cn.edu.hebtu.software.taobao.Bean;

public class Info {
  private String count;
  private String infoName;

  public Info(String count, String infoName) {
    this.count = count;
    this.infoName = infoName;
  }

  public String getCount() {
    return count;
  }

  public void setCount(String count) {
    this.count = count;
  }

  public String getInfoName() {
    return infoName;
  }

  public void setInfoName(String infoName) {
    this.infoName = infoName;
  }
}
