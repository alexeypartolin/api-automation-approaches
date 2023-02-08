package backend.methods.positivemethods;

import backend.context.Context;
import backend.helpers.Endpoints;
import backend.helpers.RandomData;
import backend.pojo.petcontroller.getfindpetbyid.PojoResFindPetById;
import backend.pojo.petcontroller.postaddnewpet.request.Category;
import backend.pojo.petcontroller.postaddnewpet.request.PojoReqAddNewPet;
import backend.pojo.petcontroller.postaddnewpet.request.Tags;
import backend.service.SerivceMethodsTemplate;
import backend.service.positivemethods.ServicePositiveMethods;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PositiveMethods {
    public static class Post {
        public static PojoReqAddNewPet postCreateANewPet() {
            RandomData randomData = new RandomData();
            List<Object> photoUrlsList = new ArrayList<>();

            for (int i = 0; i < 2; i++) {
                photoUrlsList.add(RandomData.RandomDataCreateNewPet.setUrl());
            }

            //////////

            List<Tags> listTags = new ArrayList<>();

            Tags tag1 = Tags.builder()
                    .id(3)
                    .name("fast")
                    .build();

            Tags tag2 = Tags.builder()
                    .id(7)
                    .name("small")
                    .build();

            Tags tag3 = Tags.builder()
                    .id(9)
                    .name("smart")
                    .build();

            listTags.add(tag1);
            listTags.add(tag2);
            listTags.add(tag3);

            var requestBody = PojoReqAddNewPet.builder()
                    .id(RandomData.RandomDataCreateNewPet.setLongId())
                    .name(RandomData.RandomDataCreateNewPet.setDogName())
                    .status("available")
                    .category(Category.builder().id(2).name("Dogs").build())
                    .photoUrls(photoUrlsList)
                    .tags(listTags).build();
            var endpoint = Endpoints.Post.createNewPet();
            var pojoClass = PojoReqAddNewPet.class;


            var responseBody = ServicePositiveMethods.postToRootPojo(endpoint, requestBody, pojoClass);
            System.out.println(responseBody);

            Context.petId = responseBody.getId().longValue();

            return responseBody;
        }
    }

    public static class Get {
        public static List<PojoResFindPetById> getFindPetsByStatus() {
            var endpoint = Endpoints.Get.findPetByStatus();
            var pojoClass = PojoResFindPetById.class;
            HashMap<String, String> params = new HashMap<>();
            params.put("status", "available");

            var responseBody = ServicePositiveMethods.getToListPojoJsonPathData(endpoint, pojoClass, params);

            return responseBody;
        }
    }
}
