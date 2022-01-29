package com.example.nustahackathon;

public class database {
        private String Fname;
        private String Lname;
        private String pass;
        private String cpass;
        private String email;

        public database() {
        }

        public database(String fname, String lname, String pass, String cpass, String email) {
            Fname = fname;
            Lname = lname;
            this.pass = pass;
            this.cpass = cpass;
            this.email = email;
        }

        public String getFname() {
            return Fname;
        }

        public void setFname(String fname) {
            Fname = fname;
        }

        public String getLname() {
            return Lname;
        }

        public void setLname(String lname) {
            Lname = lname;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

        public String getCpass() {
            return cpass;
        }

        public void setCpass(String cpass) {
            this.cpass = cpass;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }



