package backend.helpers;

public class Endpoints {
    public static class Get {
        // https://petstore.swagger.io/#/pet/getPetById
        public static String findPetById(Integer id) {
            return "v2/pet/" + id;
        }
    }

    public static class Post {
        public static String createNewPet() {
            return "v2/pet";
        }
    }
}
