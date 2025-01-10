package kr.pet.mvc;

import java.util.ArrayList;
import java.util.List;

//진료 기록을 관리하는 컨트롤러
public class MedicalRecordController {
    private List<MedicalRecord> records = new ArrayList<>();//여러 개의 진료기록을 기록하는 리스트 필요.

    //진료 기록을 등록하는 메서드
    public void addMedicalRecord(MedicalRecord record){
        records.add(record);
    }

    //진료 기록을 삭제하는 메서드
    public void removeMedicalRecord(String phoneNumber){
        for(int i=0; i<records.size(); i++){
            if (records.get(i).getPhoneNumber().equals(phoneNumber)){ //같은 전화번호의 진료기록을 삭제.
                records.remove(i);
                break;
            }
        }
    }

    //전화번호에 해당하는 모든 진료기록을 검색하여 새로운 List<MedicalRecord>를 만들어주는 메서드
    //여러 동물들의 진료기록이 담겨있는 reccords에서 전화번호에 일치하는 새로운 진료기록을 만들어줘 해당 동물의 진료기록만 볼 수 있도록
    public List<MedicalRecord> findMedicalRecords(String phoneNumber){
        List<MedicalRecord> result = new ArrayList<>();
        for(MedicalRecord record : records){
            if(record.getPhoneNumber().equals(phoneNumber)){
                result.add(record);
            }
        }
        return result;
    }
}
