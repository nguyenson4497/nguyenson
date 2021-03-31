package com.example.task1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Button btnAdd, btnEdit, btnRemove, btnSortName, btnSortYear, btnSortPhone, btnFilterCD, btnFilterDH, btnShow;
    private EditText edtName, edtBirthDay, edtPhone, edtField, edtLevel, edtFind;
    private ImageView ivFind;
    private List<Student> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //List
        list = new ArrayList<>();
        list.add(new Student("Nguyen Son", "1997", "0984988089", "Cong nghe thong tin", "Dai hoc"));
        list.add(new Student("Thuy Thuy", "1996", "0123456789", "Ke toan", "Dai hoc"));
        list.add(new Student("Thuy Dung", "2000", "0987654321", "Marketing", "Cao dang"));
        list.add(new Student("Hoang Anh", "1995", "0999999999", "Quan tri", "Cao dang"));
        list.add(new Student("thu thao", "1993", "0912999999", "Quan tri", "Cao dang"));


        //Button
        btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addStudent();
            }
        });

        btnEdit = findViewById(R.id.btn_edit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editStudent();
            }
        });

        btnRemove = findViewById(R.id.btn_remove);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeStudent();
            }
        });

        btnSortName = findViewById(R.id.btn_sort_name);
        btnSortName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortNameStudent();
            }
        });

        btnSortYear = findViewById(R.id.btn_sort_birth_day);
        btnSortYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortYearStudent();
            }
        });

        btnSortPhone = findViewById(R.id.btn_sort_phone_number);
        btnSortPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortPhoneStudent();
            }
        });

        btnShow = findViewById(R.id.btn_show);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showListStudents();
            }
        });

        btnFilterCD = findViewById(R.id.btn_filter_cd);
        btnFilterCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterCD();
            }
        });

        btnFilterDH = findViewById(R.id.btn_filter_dh);
        btnFilterDH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterDH();
            }
        });

        //ImageView
        ivFind = findViewById(R.id.iv_find);
        ivFind.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findInfo();
            }
        }));

        //EditText
        edtName = findViewById(R.id.edt_name);
        edtBirthDay = findViewById(R.id.edt_birth_day);
        edtPhone = findViewById(R.id.edt_phone_number);
        edtField = findViewById(R.id.edt_field);
        edtLevel = findViewById(R.id.edt_level);
        edtFind = findViewById(R.id.edt_find);
    }

    //Find
    public void findInfo() {
        String keyWord = edtFind.getText().toString();
        if (keyWord.length() == 0) {
            Toast.makeText(this, "Cần nhập từ khóa trước khi tìm kiếm", Toast.LENGTH_SHORT).show();
            return;
        }
        for (Student student : list) {
            if (student.getName().trim().toLowerCase().contains(keyWord.trim().toLowerCase()) ||
                    student.getPhoneNumber().trim().toLowerCase().contains(keyWord.trim().toLowerCase()) ||
                    student.getBirthDay().trim().toLowerCase().contains(keyWord.trim().toLowerCase()) ||
                    student.getField().trim().toLowerCase().contains(keyWord.trim().toLowerCase())) {
                Log.i("List Student", "|-------List Student-------|"
                        + "\n" + student.getName() + " | " + student.getBirthDay() +
                        " | " + student.getPhoneNumber() + " | " + student.getField()
                        + " | " + student.getLevel() + "\n");
            }
        }
    }

    //Sort
    public void sortPhoneStudent() {
        Toast.makeText(this, "Sắp xếp theo số điện thoại", Toast.LENGTH_SHORT).show();
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getPhoneNumber().compareTo(s2.getPhoneNumber());
            }
        });
        showListStudents();
    }

    public void sortNameStudent() {
        Toast.makeText(this, "Sắp xếp theo tên", Toast.LENGTH_SHORT).show();
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().substring(s1.getName().trim().lastIndexOf(" "))
                        .compareTo(s2.getName().substring(s2.getName().trim().lastIndexOf(" ")));
            }
        });
        showListStudents();
    }

    public void sortYearStudent() {
        Toast.makeText(this, "Sắp xếp theo năm sinh", Toast.LENGTH_SHORT).show();
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return -s1.getBirthDay().compareTo(s2.getBirthDay());
            }
        });
        showListStudents();
    }

    //Remove
    public void removeStudent() {
        String phone = edtPhone.getText().toString();
        if (list.size() == 0) {
            Toast.makeText(this, "Không có sinh viên để xóa", Toast.LENGTH_SHORT).show();
            return;
        } else if (phone.length() == 0) {
            Toast.makeText(this, "Vui lòng nhập số điện thoại sinh viên cần xóa", Toast.LENGTH_SHORT).show();
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getPhoneNumber().trim().toString().equals(phone.trim())) {
                    list.remove(i);
                    edtPhone.setText("");
                }
            }
        }
    }

    //Edit
    public void editStudent() {
        String phone = edtPhone.getText().toString();
        if (list.size() == 0) {
            Toast.makeText(this, "Không có sinh viên để sửa", Toast.LENGTH_SHORT).show();
            return;
        } else if (phone.length() == 0) {
            Toast.makeText(this, "Vui lòng nhập số điện thoại sinh viên cần sửa", Toast.LENGTH_SHORT).show();
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getPhoneNumber().trim().toString().equals(phone.trim())) {
                    editPhone(list.get(i));
                }
            }
        }
    }

    private void editPhone(Student student) {
        String name = edtName.getText().toString();
        String birthDay = edtBirthDay.getText().toString();
        String field = edtField.getText().toString();
        String level = edtLevel.getText().toString();
        if (name.length() == 0 || birthDay.length() == 0 || field.length() == 0 || level.length() == 0) {
            Toast.makeText(this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
        } else {
            student.setName(name);
            student.setBirthDay(birthDay);
            student.setField(field);
            student.setLevel(level);
            Toast.makeText(this, "Đã cập nhật thông tin mới cho sinh viên", Toast.LENGTH_SHORT).show();
            edtName.setText("");
            edtBirthDay.setText("");
            edtPhone.setText("");
            edtField.setText("");
            edtLevel.setText("");
        }
    }

    //Add
    public void addStudent() {
        String name = edtName.getText().toString();
        String birthDay = edtBirthDay.getText().toString();
        String phone = edtPhone.getText().toString();
        String field = edtField.getText().toString();
        String level = edtLevel.getText().toString();

        if (name.length() == 0 || birthDay.length() == 0 || phone.length() == 0 || field.length() == 0 || level.length() == 0) {
            Toast.makeText(this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (phone.equals(list.get(i).toString())) {
                    Log.i("Failed!", "Số điện thoại đã tồn tại");
                    return;
                }
            }
            Student student = new Student(name, birthDay, phone, field, level);
            list.add(student);
            Toast.makeText(this, "Đã thêm thành công!", Toast.LENGTH_SHORT).show();
            showListStudents();
            edtName.setText("");
            edtBirthDay.setText("");
            edtPhone.setText("");
            edtField.setText("");
            edtLevel.setText("");
        }
    }

    //Show
    public void showListStudents() {
        for (Student student : list) {
            Log.i("List Student", "|-------List Student-------|"
                    + "\n" + student.getName() + " | " + " | " + student.getPhoneNumber()
                    + " | " + student.getLevel() + "\n");
        }
    }

    //Filter
    public void filterCD() {
        for (Student student : list) {
            if (student.getLevel().trim().equals("Cao dang")) {
                Log.i("List Student", "|-------List Student-------|"
                        + "\n" + student.getName() + " | " + student.getBirthDay() +
                        " | " + student.getPhoneNumber() + " | " + student.getField()
                        + " | " + student.getLevel() + "\n");
            }
        }
    }

    public void filterDH() {
        for (Student student : list) {
            if (student.getLevel().trim().equals("Dai hoc")) {
                Log.i("List Student", "|-------List Student-------|"
                        + "\n" + student.getName() + " | " + student.getBirthDay() +
                        " | " + student.getPhoneNumber() + " | " + student.getField()
                        + " | " + student.getLevel() + "\n");
            }
        }
    }


}