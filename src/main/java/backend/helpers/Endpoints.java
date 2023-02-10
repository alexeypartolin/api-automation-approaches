package backend.helpers;

public class Endpoints {
    public static class Get {
        // https://petstore.swagger.io/#/pet/getPetById
        public static String findPetById(Integer id) {
            return "v2/pet/" + id;
        }
        public static String findPetByStatus() {
            return "v2/pet/findByStatus";
        }
    }

    public static class Post {
        public static String createNewPet() {
            return "v2/pet";
        }
    }

    public static class Put {
        public static String putUpdateAnExistingPet() {return "v2/pet"; }
    }

    public static class Delete {
        public static String deleteAnExistingPet(Integer id) {
            return "v2/pet/" + id;
        }
    }
}
