package aptechph.com.studentApp.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RegisterResponseDTO {
    public String message;
    public Long id;

//    public RegisterResponseDTO(String message, Long id) {
//        this.message = message;
//        this.id = id;
//    }

//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
}
