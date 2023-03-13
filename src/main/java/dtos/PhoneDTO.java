package dtos;

public class PhoneDTO {

        private Long number;
        private String description;

        public PhoneDTO(Long number, String description) {
            this.number = number;
            this.description = description;
        }

        public Long getNumber() {
            return number;
        }

        public void setNumber(Long number) {
            this.number = number;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
}
