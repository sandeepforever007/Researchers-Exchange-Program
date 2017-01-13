/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment4.util;

/**
 *
 * @author Jai Kiran
 */
public class Queries {
    
    public static final String SELECT_USER_FRM_EMAIL="SELECT NAME,USERNAME,TYPE,STUDIES,PARTICIPATION,COINS FROM USER WHERE USERNAME=?";
    public static final String SELECT_UNACTUSER_FRM_EMAIL="SELECT NAME,USERNAME,TYPE,STUDIES,PARTICIPATION,COINS,PASSWORD FROM USER_UNACTIVATED WHERE USERNAME=?";
    public static final String INSERT_USER="INSERT INTO USER(NAME,USERNAME,PASSWORD,SALT,TYPE,STUDIES,PARTICIPATION,COINS) VALUES(?,?,?,?,?,?,?,?)";
    public static final String INSERT_USER_ACTIVATION="INSERT INTO USER_UNACTIVATED(NAME,USERNAME,PASSWORD,SALT,TYPE,STUDIES,PARTICIPATION,COINS, TOKEN) VALUES(?,?,?,?,?,?,?,?,?)";
    public static final String DELETE_ACTIVATED_USER = "DELETE FROM USER_UNACTIVATED WHERE USERNAME = ?";
    public static final String VALIDATE_USER="SELECT NAME,USERNAME,TYPE,STUDIES,PARTICIPATION,COINS FROM USER WHERE USERNAME=? AND PASSWORD=?";
    public static final String GET_STUDY_FRM_EMAIL="SELECT S.STUDYID,S.STUDYNAME,S.DESCRIPTION,S.USERNAME,S.DATECREATED,S.REQPARTICIPANTS,S.ACTPARTICIPANTS,S.SSTATUS,Q.QUESTION,Q.ANSWERTYPE,Q.NOOFANSWERS,Q.OPTION1,Q.OPTION2,Q.OPTION3,Q.OPTION4,Q.OPTION5,S.IMAGEURL,Q.QUESTIONID FROM STUDY S,QUESTION Q WHERE S.STUDYID=Q.STUDYID AND USERNAME=?";
    public static final String GET_STUDY_FRM_EMAIL_AND_STUDYCODE="SELECT S.STUDYID,S.STUDYNAME,S.DESCRIPTION,S.USERNAME,S.DATECREATED,S.REQPARTICIPANTS,S.ACTPARTICIPANTS,S.SSTATUS,Q.QUESTION,Q.ANSWERTYPE,Q.NOOFANSWERS,Q.OPTION1,Q.OPTION2,Q.OPTION3,Q.OPTION4,Q.OPTION5,S.IMAGEURL,Q.QUESTIONID FROM STUDY S,QUESTION Q WHERE S.STUDYID=Q.STUDYID AND S.USERNAME=? AND S.STUDYID=?";
    public static final String INSERT_STUDY_WITH_IMAGE="INSERT INTO STUDY(STUDYNAME,DESCRIPTION,USERNAME,DATECREATED,IMAGEURL,REQPARTICIPANTS,ACTPARTICIPANTS,SSTATUS) VALUES (?,?,?,NOW(),?,?,?,?)";
    public static final String INSERT_STUDY_WITHOUT_IMAGE="INSERT INTO STUDY(STUDYNAME,DESCRIPTION,USERNAME,DATECREATED,REQPARTICIPANTS,ACTPARTICIPANTS,SSTATUS) VALUES (?,?,?,NOW(),?,?,?)";
    public static final String INSERT_QUESTION="INSERT INTO QUESTION(STUDYID,QUESTION,ANSWERTYPE,NOOFANSWERS,OPTION1,OPTION2,OPTION3,OPTION4,OPTION5)VALUES (?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_STUDY_WITH_IMAGE="UPDATE STUDY SET IMAGEURL=?,REQPARTICIPANTS=?,DESCRIPTION=? WHERE STUDYID=? AND STUDYNAME=?";
    public static final String UPDATE_STUDY_WITHOUT_IMAGE="UPDATE STUDY SET REQPARTICIPANTS=?,DESCRIPTION=? WHERE STUDYID=? AND STUDYNAME=?";
    public static final String UPDATE_QUESTION="UPDATE QUESTION SET QUESTION=?,ANSWERTYPE=?,NOOFANSWERS=?,OPTION1=?,OPTION2=?,OPTION3=?,OPTION4=?,OPTION5=? WHERE STUDYID=?";
    public static final String UPDATE_STUDY_STATUS="UPDATE STUDY SET SSTATUS=? WHERE STUDYID=?";
    public static final String GET_OPEN_STUDIES="SELECT A.* FROM(SELECT S.STUDYID,S.STUDYNAME,S.DESCRIPTION,S.USERNAME,S.DATECREATED,S.REQPARTICIPANTS,S.ACTPARTICIPANTS,S.SSTATUS,Q.QUESTION,Q.ANSWERTYPE,Q.NOOFANSWERS,Q.OPTION1,Q.OPTION2,Q.OPTION3,Q.OPTION4,Q.OPTION5,S.IMAGEURL,Q.QUESTIONID FROM STUDY S,QUESTION Q WHERE S.STUDYID=Q.STUDYID AND S.SSTATUS='"+CommonUtility.Study_Status_Start+"' AND S.USERNAME<> ?)A WHERE A.QUESTIONID NOT IN (SELECT QUESTIONID FROM ANSWER WHERE USERNAME<> A.USERNAME)";
    public static final String GET_STUDY_FRM_STUDYCODE="SELECT S.STUDYID,S.STUDYNAME,S.DESCRIPTION,S.USERNAME,S.DATECREATED,S.REQPARTICIPANTS,S.ACTPARTICIPANTS,S.SSTATUS,Q.QUESTION,Q.ANSWERTYPE,Q.NOOFANSWERS,Q.OPTION1,Q.OPTION2,Q.OPTION3,Q.OPTION4,Q.OPTION5,S.IMAGEURL,Q.QUESTIONID FROM STUDY S,QUESTION Q WHERE S.STUDYID=Q.STUDYID AND S.STUDYID=?";
    public static final String INSERT_ANSWER="INSERT INTO ANSWER(STUDYID,QUESTIONID,USERNAME,CHOICE,DATESUBMITTED) VALUES (?,?,?,?,NOW())";
    public static final String UPDATE_USER_PARTICIPATION="UPDATE USER SET PARTICIPATION=PARTICIPATION+1,COINS=COINS+1 WHERE USERNAME=?";
    public static final String UPDATE_STUDY_PARTICIPATION="UPDATE STUDY SET ACTPARTICIPANTS=ACTPARTICIPANTS+1 WHERE STUDYID=?";
    public static final String INSERT_REPORTED="INSERT INTO REPORTED(QUESTIONID,STUDYID,DATE,USERNAME) VALUES (?,?,NOW(),?)";
    public static final String INSERT_REPORTED_STATUS="INSERT INTO REPORTED_STATUS(QUESTIONID,STUDYID,STATUS) VALUES (?,?,?)";
    public static final String VALIDATE_REPORTED_BY_USER="SELECT QUESTIONID,STUDYID,DATE,USERNAME FROM REPORTED WHERE QUESTIONID=? AND STUDYID=? AND USERNAME=?";
    public static final String VALIDATE_REPORTED_STATUS="SELECT QUESTIONID,STUDYID,STATUS FROM REPORTED_STATUS WHERE QUESTIONID=? AND STUDYID=?";
    public static final String FETCH_REPORT_HISTORY="SELECT R.DATE,Q.QUESTION,RS.STATUS FROM REPORTED R,REPORTED_STATUS RS,QUESTION Q WHERE R.QUESTIONID=RS.QUESTIONID AND R.STUDYID=RS.STUDYID AND RS.QUESTIONID=Q.QUESTIONID AND RS.STUDYID=Q.STUDYID AND R.QUESTIONID=Q.QUESTIONID AND R.STUDYID=Q.STUDYID AND R.USERNAME=?";
    public static final String FETCH_REPORTED_QUESTIONS="SELECT Q.QUESTION,COUNT(R.USERNAME) NUMOFPARTICIPANTS,RS.STUDYID,Q.QUESTIONID FROM REPORTED R,REPORTED_STATUS RS,QUESTION Q WHERE R.QUESTIONID=RS.QUESTIONID AND R.STUDYID=RS.STUDYID AND RS.QUESTIONID=Q.QUESTIONID AND RS.STUDYID=Q.STUDYID AND R.QUESTIONID=Q.QUESTIONID AND R.STUDYID=Q.STUDYID AND RS.STATUS=? GROUP BY Q.QUESTION,RS.STUDYID,Q.QUESTIONID";
    public static final String UPDATE_REPORT_RECORD="UPDATE REPORTED_STATUS SET STATUS=? WHERE STUDYID=? AND QUESTIONID=?";
    public static final String GET_USER_SALT="SELECT SALT FROM USER WHERE USERNAME=?";
    public static final String UPDATE_PASSWORD = "UPDATE USER SET PASSWORD =?, SALT = ? WHERE USERNAME = ?";
    public static final String INSERT_FORGOT_PASSWORD="INSERT INTO FORGOT_PASSWORD(USERNAME,TOKEN,DATECREATED) VALUES (?,?,NOW()) ";
    public static final String SELECT_FORGOT_PWD_RECORD="SELECT IFNULL(COUNT(*),0) FROM FORGOT_PASSWORD WHERE USERNAME=? AND TOKEN=? AND DATE(DATECREATED) =(SELECT DATE(MAX(DATECREATED)) FROM FORGOT_PASSWORD WHERE USERNAME=?)";
}
