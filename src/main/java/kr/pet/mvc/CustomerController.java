package kr.pet.mvc;

import java.util.ArrayList;
import java.util.List;

//고객정보를 관리해주는 클래스
public class CustomerController {
    private List<Customer> customers; //여러 고객을 관리해야하므로 리스트가 필요.
    private MedicalRecordController recordController; //진료 기록을 관리하는 컨트롤러가 필요.

    public CustomerController(MedicalRecordController recordController) {
        this.customers = new ArrayList<>(); //빈 배열 생성
        this.recordController = recordController; //매개변수로 넘어온 RecordController를 넣어줌.
    }

    //고객 정보를 등록하는 메서드
    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    //고객정보를 삭제하는 메서드 (반드시 해당 고객의 진료기록도 함께 삭제)
    public void removeCustomer(String phoneNumber){
        for (int i=0; i<customers.size(); i++){
            if(customers.get(i).getPhoneNumber().equals(phoneNumber)){
                customers.remove(i);
                recordController.removeMedicalRecord(phoneNumber);
                break;
            }
        }
    }

    //고객등록 여부를 확인하는 메서드
    public Customer findCustomer(String phoneNumber){
        for (Customer customer : customers){
            if(customer.getPhoneNumber().equals(phoneNumber)){ //일치하는 게 있다면 그 고객정보 넘겨주기
                return customer;
            }
        }
        return null;
    }

    //기존의 전화번호로 등록된 고객이 있는지 확인하는 메서드(중복 체크)
    public boolean isPhoneNumberExist(String phoneNumber){
        for(Customer customer : customers){
            if(customer.getPhoneNumber().equals(phoneNumber)){
                return true;
            }
        }
        return false;
    }
}
