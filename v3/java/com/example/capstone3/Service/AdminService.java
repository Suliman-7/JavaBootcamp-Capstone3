package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.Admin;
import com.example.capstone3.Model.Captain;
import com.example.capstone3.Model.Report;
import com.example.capstone3.Repository.AdminRepository;
import com.example.capstone3.Repository.CaptainRepository;
import com.example.capstone3.Repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class AdminService {

    private final AdminRepository adminRepository;
    private final ReportRepository reportRepository;
    private final CaptainRepository captainRepository;

    public List<Admin> getAllAdmins(){
        return adminRepository.findAll();
    }

    public void addAdmin(Admin admin){
        adminRepository.save(admin);
    }

    public void updateAdmin( int id ,Admin admin1){
        Admin admin = adminRepository.findAdminById(id);
        if(admin == null){
            throw new ApiException("Admin not found");
        }
        admin.setName(admin1.getName());
        admin.setEmail(admin1.getEmail());
        admin.setPhoneNumber(admin1.getPhoneNumber());
    }

    public void deleteAdmin(int id){
        Admin admin = adminRepository.findAdminById(id);
        if(admin == null){
            throw new ApiException("Admin not found");
        }
        adminRepository.delete(admin);
    }

    public List<Report> displayAllReports(){
       return reportRepository.findAll();
    }

    public void makeWarnToCaptain(int captainId){
        Captain captain = captainRepository.findCaptainById(captainId);

        if(captain == null){
            throw new ApiException("Captain not found");
        }
        Report report = reportRepository.findReportByCapId(captain.getId());
        if(report == null){
            throw new ApiException("Selected captain doesn't had any Report on him");
        }

        if (captain.isSuspend()){
            throw new ApiException("Captain is suspended");
        }

        captain.setWarns(captain.getWarns()+1);

        if (captain.getWarns()==3){
            captain.setSuspend(true);
        }
        captainRepository.save(captain);
    }
}
