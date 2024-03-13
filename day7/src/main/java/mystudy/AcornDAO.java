package mystudy;
//model파일

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AcornDAO {
    // JDBC 드라이버 정보
    String driver = "oracle.jdbc.driver.OracleDriver";
    // 데이터베이스 URL
    String url = "jdbc:oracle:thin:@localhost:1521:testdb";
    // 데이터베이스 접속 계정 정보
    String user = "scott";
    String password = "tiger";
    
    // 학생 정보 조회 메서드
    public Acorn selectOne(String id) {
        // 조회된 학생 정보를 담을 Acorn 객체
        Acorn acorn = null;
        // 데이터베이스 연결 관련 객체들
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            // JDBC 드라이버 로드
            Class.forName(driver);
            // 데이터베이스에 연결
            con = DriverManager.getConnection(url, user, password);
            // SQL 쿼리 작성
            String sql = "SELECT * FROM acorntbl WHERE id = ?";
            // 준비된 문 생성
            pst = con.prepareStatement(sql);
            // SQL 쿼리의 매개변수 설정
            pst.setString(1, id);
            // SQL 쿼리 실행 및 결과 집합 획득
            rs = pst.executeQuery();
            
            // 결과 집합에 데이터가 있다면
            if (rs.next()) {
                // 결과 집합에서 학생의 비밀번호와 이름을 가져와서 Acorn 객체 생성
                String pw = rs.getString("pw");
                String name = rs.getString("name");
                acorn = new Acorn(id, pw, name);
            }
        } catch (ClassNotFoundException | SQLException e) {
            // 예외 발생 시 출력
            e.printStackTrace();
        } finally {
            try {
                // 자원 해제
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                // 예외 발생 시 출력
                e.printStackTrace();
            }
        }
        
        // 조회된 학생 정보 반환
        return acorn;
    }
}