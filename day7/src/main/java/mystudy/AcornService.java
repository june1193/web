package mystudy;
//model파일


public class AcornService {
    // AcornDAO 객체 생성
    private AcornDAO dao = new AcornDAO();
    
    // 특정 학생 정보 조회 메서드
    public Acorn getMember(String id) {
        // AcornDAO를 통해 학생 정보 조회
        return dao.selectOne(id);
    }
}