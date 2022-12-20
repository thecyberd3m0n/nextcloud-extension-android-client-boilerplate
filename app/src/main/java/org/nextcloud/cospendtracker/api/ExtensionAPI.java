package org.nextcloud.ncextension.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ExtensionAPI {
//    TODO: set your extension endpoint
    String mApiEndpoint = "/index.php/apps/extension/";
// TODO: set your methods
    /** FOLDERS **/
//    @GET("folders")
//    Observable<List<Folder>> folders();

//    /** FEEDS **/
//    @GET("feeds")
//    Observable<List<Feed>> feeds();

//    @POST("folders")
//    Call<List<Folder>> createFolder(@Body Map<String, Object> folderMap);
//
//    @POST("folders")
//    Observable<List<Folder>> createFolderObservable(@Body Map<String, Object> folderMap);
//
//    @FormUrlEncoded
//    @POST("feeds")
//    Call<List<Feed>> createFeed(@Field("url") String url, @Field("folderId") Long parentFolderID);

//
//    @PUT("feeds/{feedId}/rename")
//    Completable renameFeed(@Path("feedId") long feedId, @Body Map<String, String> paramMap);

//    /** ITEMS **/
//    @GET("items")
//    Call<List<RssItem>> items(
//            @Query("batchSize") long batchSize,
//            @Query("offset") long offset,
//            @Query("type") int type,
//            @Query("id") long id,
//            @Query("getRead") boolean getRead,
//            @Query("oldestFirst") boolean oldestFirst
//    );
//
//    @GET("items/updated")
//    @Streaming
//    Observable<ResponseBody> updatedItems(
//            @Query("lastModified") long lastModified,
//            @Query("type") int type,
//            @Query("id") long id
//    );

//
//    @PUT("items/read/multiple")
//    Call<Void> markItemsRead(@Body ItemIds items);


}
