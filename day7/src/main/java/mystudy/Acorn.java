package mystudy;
//model파일
public class Acorn {
    // 학생 정보를 담을 변수들
    String id;
    String pw;
    String name;
    
    // 생성자: 학생 정보를 초기화하는 메서드
    public Acorn(String id, String pw, String name) {
        super();
        this.id = id;
        this.pw = pw;
        this.name = name;
    }
    
    // Getter 및 Setter 메서드들
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 객체의 문자열 표현을 반환하는 메서드
    @Override
    public String toString() {
        return "Acorn [id=" + id + ", pw=" + pw + ", name=" + name + "]";
    }   
}
