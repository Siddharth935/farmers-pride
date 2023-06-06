package com.example.shetkarifarmer.CropActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.shetkarifarmer.Models.VegatbleModel;
import com.example.shetkarifarmer.R;
import com.example.shetkarifarmer.databinding.ActivityPotatoBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.InputStream;
import java.util.List;

public class Potato extends AppCompatActivity {
    private ActivityPotatoBinding binding;
    private Uri filepath;
    private Bitmap bitmap;
    private FirebaseStorage storage;
    private StorageReference storageReference;
    private FirebaseDatabase rootNode;
    private DatabaseReference reference, referenceTwo ,referenceThree;
    private int REQUEST_CODE = 205;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPotatoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        referenceThree = FirebaseDatabase.getInstance().getReference("UserProfile").child(FirebaseAuth.getInstance().getCurrentUser().getUid());


        referenceThree.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String getCity = snapshot.child("city").getValue().toString();
                    binding.City.setText(getCity);
                    String getfarmerName = snapshot.child("farmerName").getValue().toString();
                    binding.farmerName.setText(getfarmerName);
                    String getfarmerMobileNumber = snapshot.child("farmerMobileNumber").getValue().toString();
                    binding.farmerMobileNumber.setText(getfarmerMobileNumber);
                    String getfarmerMobileNumberTwo = snapshot.child("farmerMobileNumberTwo").getValue().toString();
                    binding.farmerMobileNumberTwo.setText(getfarmerMobileNumberTwo);
                    String getfarmerEmail = snapshot.child("farmerEmail").getValue().toString();
                    binding.farmerEmail.setText(getfarmerEmail);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        binding.selectCropImage.setOnClickListener(v -> Dexter.withActivity(Potato.this).withPermissions(Manifest.permission.READ_EXTERNAL_STORAGE).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
//                Intent intent = new Intent(Intent.ACTION_PICK);
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Select Image File"), REQUEST_CODE);
            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }
        }).check());

        binding.submit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (binding.CropName.getEditableText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), R.string.enter_detail_about_crop, Toast.LENGTH_SHORT).show();
                else if (binding.Rate.getEditableText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), R.string.enter_your_rate_per_kg, Toast.LENGTH_SHORT).show();
                else if (binding.farmerName.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), R.string.enter_your_name, Toast.LENGTH_SHORT).show();
                else if (binding.farmerMobileNumber.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), R.string.enter_your_mobile_number, Toast.LENGTH_SHORT).show();
                else if (binding.CropKG.getEditableText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), R.string.enter_your_crop_weight, Toast.LENGTH_SHORT).show();
                else if (binding.farmerMobileNumberTwo.getText().toString().isEmpty() || binding.farmerEmail.getText().toString().isEmpty()) {
                    binding.farmerMobileNumberTwo.setText("Not Uploaded");
                    binding.farmerEmail.setText("Not Uploaded");
                } else
                    upload();
            }
        });
    }

    private void upload() {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("File Uploader");
        dialog.show();

        String CropName = binding.CropName.getEditableText().toString();
        String Rate = binding.Rate.getEditableText().toString();
        String farmerName = binding.farmerName.getText().toString();
        String farmerMobileNumber = binding.farmerMobileNumber.getText().toString();
        String farmerMobileNumberTwo = binding.farmerMobileNumberTwo.getText().toString();
        String farmerEmail = binding.farmerEmail.getText().toString();
        String CropKG = binding.CropKG.getEditableText().toString();
        String City = binding.City.getText().toString();


        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference("Potato").child(""+farmerMobileNumber);


        storageReference.putFile(filepath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        rootNode = FirebaseDatabase.getInstance();
                        reference = rootNode.getReference("AllVegetable").child("Potato").child("" + farmerMobileNumber);
                        referenceTwo = rootNode.getReference("Vegetable");
                        VegatbleModel vegatbleModel = new VegatbleModel(CropName, Rate, farmerName, farmerMobileNumber, farmerMobileNumberTwo, farmerEmail, CropKG,City, uri.toString());
                        Toast.makeText(getApplicationContext(), "Uploaded", Toast.LENGTH_SHORT).show();
                        reference.setValue(vegatbleModel);
                        referenceTwo.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Potato").setValue(vegatbleModel);
                    }
                });
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                int percentage = (int) ((100 * snapshot.getBytesTransferred()) / snapshot.getTotalByteCount());
                dialog.setMessage("Uploading " + (int) percentage + " %...");
                if (percentage == 100) {
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(), R.string.uploaded, Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            assert data != null;
            filepath = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(filepath);
                bitmap = BitmapFactory.decodeStream(inputStream);
                binding.CropImage.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}