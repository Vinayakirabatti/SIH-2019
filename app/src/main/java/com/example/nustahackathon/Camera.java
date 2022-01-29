package com.example.nustahackathon;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Hashtable;
import java.util.Map;

public class Camera extends AppCompatActivity {
        Button button1,button2,button3,button4,button5,button6,button7,button8;
        private ImageView image1, image2, image3,image4,image5,image6,image7,image8;
        private ImageView[] image = { image1, image2, image3,image4,image5,image6,image7,image8 };
        private Bitmap encodeimage2, encodeimage3,encodeimage4,encodeimage5,encodeimage6,encodeimage7,encodeimage8;
        private Intent intent1, intent2, intent3,intent4,intent5,intent6,intent7,intent8;
        private Intent[] intent = { intent1, intent2, intent3,intent4,intent5,intent6,intent7,intent8 };
        private Button submit;
        Bitmap encodeimage1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_camera);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            button1=findViewById(R.id.button1);
            button2=findViewById(R.id.button2);
            button3=findViewById(R.id.button3);
            button4=findViewById(R.id.button4);
            button5=findViewById(R.id.button5);
            button6=findViewById(R.id.button6);
            button7=findViewById(R.id.button7);
            button8=findViewById(R.id.button8);
            image1=findViewById(R.id.image1);
            image2=findViewById(R.id.image2);
            image3=findViewById(R.id.image3);
            image4=findViewById(R.id.image4);
            image5=findViewById(R.id.image5);
            image6=findViewById(R.id.image6);
            image7=findViewById(R.id.image7);
            image8=findViewById(R.id.image8);
            submit = findViewById(R.id.save);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent1=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent1,1);
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent2=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent2,2);
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent3=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent3,3);
                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent4=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent4,4);
                }
            });
            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent5=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent5,5);
                }
            });
            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent6=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent6,6);
                }
            });
            button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent7=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent7,7);
                }
            });
            button8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent8=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent8,8);
                }
            });

            submit.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {
                    Toast.makeText(Camera.this,  "clicked", Toast.LENGTH_SHORT).show();

                    uploadImage();


                }
            });
        }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i= new Intent(this,inspectionlist.class);
        startActivityForResult(i,0);
        return true;
    }

    public String getStringImage(Bitmap bmp){
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] imageBytes = baos.toByteArray();
            String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
            return encodedImage;
        }
        private void uploadImage(){
            //Showing the progress dialog
            String UPLOAD_URL = "http://192.168.43.16/hackathon/uploadimg.php";
            final ProgressDialog loading = ProgressDialog.show(this,"Uploading...","Please wait...",false,false);


            StringRequest stringRequest = new StringRequest(Request.Method.POST, UPLOAD_URL,
                    new Response.Listener<String>() {


                        @Override
                        public void onResponse(String s) {
                            Log.e("re",s);
                            loading.dismiss();

                            Toast.makeText(Camera.this, s , Toast.LENGTH_LONG).show();

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {
                            //Dismissing the progress dialog
                            loading.dismiss();

                            //Showing toast
                            Toast.makeText(Camera.this, volleyError.getMessage().toString(), Toast.LENGTH_LONG).show();
                        }
                    }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    //Converting Bitmap to String
                    String image1 = getStringImage(encodeimage1);
                    String image2 = getStringImage(encodeimage2);
                    String image3 = getStringImage(encodeimage3);
                    String image4 = getStringImage(encodeimage4);
                    String image5 = getStringImage(encodeimage5);
                    String image6 = getStringImage(encodeimage6);
                    String image7 = getStringImage(encodeimage7);
                    String image8 = getStringImage(encodeimage8);
                    Map<String,String> params = new Hashtable<String, String>();
                    params.put("mainid","1");
                    params.put("image1", image1);
                    params.put("image2", image2);
                    params.put("image3", image3);
                    params.put("image4", image4);
                    params.put("image5", image5);
                    params.put("image6", image6);
                    params.put("image7", image7);
                    params.put("image8", image8);
                    return params;
                }
            };


            RequestQueue requestQueue = Volley.newRequestQueue(this);


            requestQueue.add(stringRequest);
        }


        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if(resultCode==RESULT_OK &&requestCode==1 &&button1.isEnabled()){
                File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                File file = new File(path,"example1.jpg");
                Uri outputFileUri = Uri.fromFile( file );

                Bitmap bitmap=(Bitmap)data.getExtras().get("data");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                //encodeimage1= Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);
                encodeimage1 = bitmap;
                image1.setImageBitmap(bitmap);
                intent1.putExtra( MediaStore.EXTRA_OUTPUT, outputFileUri );
                Toast.makeText(this, file.toString(), Toast.LENGTH_SHORT).show();
            }
            if(resultCode==RESULT_OK &&requestCode==2 &&button2.isEnabled()){
                File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                File file = new File(path,"example2.jpg");
                Uri outputFileUri = Uri.fromFile( file );
                Bitmap bitmap=(Bitmap)data.getExtras().get("data");

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                encodeimage2 = bitmap;

                image2.setImageBitmap(bitmap);
                intent2.putExtra( MediaStore.EXTRA_OUTPUT, outputFileUri );
                Toast.makeText(this, file.toString(), Toast.LENGTH_SHORT).show();
            }
            if(resultCode==RESULT_OK &&requestCode==3 &&button3.isEnabled()){
                File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                File file = new File(path,"example3.jpg");
                Uri outputFileUri = Uri.fromFile( file );
                Bitmap bitmap=(Bitmap)data.getExtras().get("data");

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                encodeimage3 = bitmap;



                image3.setImageBitmap(bitmap);
                intent3.putExtra( MediaStore.EXTRA_OUTPUT, outputFileUri );
                Toast.makeText(this, file.toString(), Toast.LENGTH_SHORT).show();
            }
            if(resultCode==RESULT_OK &&requestCode==4 &&button4.isEnabled()){
                File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                File file = new File(path,"example4.jpg");
                Uri outputFileUri = Uri.fromFile( file );
                Bitmap bitmap=(Bitmap)data.getExtras().get("data");


                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                encodeimage4= bitmap;

                image4.setImageBitmap(bitmap);
                intent4.putExtra( MediaStore.EXTRA_OUTPUT, outputFileUri );
                Toast.makeText(this, file.toString(), Toast.LENGTH_SHORT).show();
            }
            if(resultCode==RESULT_OK &&requestCode==5 &&button5.isEnabled()){
                File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                File file = new File(path,"example5.jpg");
                Uri outputFileUri = Uri.fromFile( file );
                Bitmap bitmap=(Bitmap)data.getExtras().get("data");


                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                encodeimage5= bitmap;

                image5.setImageBitmap(bitmap);
                intent5.putExtra( MediaStore.EXTRA_OUTPUT, outputFileUri );
                Toast.makeText(this, file.toString(), Toast.LENGTH_SHORT).show();
            }
            if(resultCode==RESULT_OK &&requestCode==6 &&button6.isEnabled()){
                File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                File file = new File(path,"example6.jpg");
                Uri outputFileUri = Uri.fromFile( file );
                Bitmap bitmap=(Bitmap)data.getExtras().get("data");


                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                encodeimage6= bitmap;

                image6.setImageBitmap(bitmap);
                intent6.putExtra( MediaStore.EXTRA_OUTPUT, outputFileUri );
                Toast.makeText(this, file.toString(), Toast.LENGTH_SHORT).show();
            }
            if(resultCode==RESULT_OK &&requestCode==7 &&button7.isEnabled()){
                File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                File file = new File(path,"example7.jpg");
                Uri outputFileUri = Uri.fromFile( file );
                Bitmap bitmap=(Bitmap)data.getExtras().get("data");

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                encodeimage7= bitmap;


                image7.setImageBitmap(bitmap);
                intent7.putExtra( MediaStore.EXTRA_OUTPUT, outputFileUri );
                Toast.makeText(this, file.toString(), Toast.LENGTH_SHORT).show();
            }
            if(resultCode==RESULT_OK &&requestCode==8 &&button8.isEnabled()){
                File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                File file = new File(path,"example8.jpg");
                Uri outputFileUri = Uri.fromFile( file );
                Bitmap bitmap=(Bitmap)data.getExtras().get("data");

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                encodeimage8= bitmap;


                image8.setImageBitmap(bitmap);
                intent8.putExtra( MediaStore.EXTRA_OUTPUT, outputFileUri );
                Toast.makeText(this, file.toString(), Toast.LENGTH_SHORT).show();
            }
        }

    }

