package cn.neusoft.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInfo {
    String c_id;
    String c_name;
    String c_identity;
    String c_orgName;
    String c_landline;
    String c_mTele;
    String c_state;
}
