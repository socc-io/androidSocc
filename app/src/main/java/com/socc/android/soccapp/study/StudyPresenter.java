package com.socc.android.soccapp.study;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.socc.android.soccapp.utills.SharePreferenceUtils;

import java.util.ArrayList;

/**
 * Created by ksang on 2017-04-01.
 */
public class StudyPresenter implements StudyContract.Presenter{
    private final StudyRepository mStudyRepository;
    private final StudyContract.View mStudyView;

    public StudyPresenter(@NonNull StudyRepository studyRepository, @NonNull StudyContract.View studyView) {
        mStudyRepository = studyRepository;
        mStudyView = studyView;
        mStudyView.setPresenter(this);
    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void loadStudys() {
        mStudyRepository.getStudies(new StudiesDataSource.LoadStudiesCallback(){
            @Override
            public void onStudiesLoaded(ArrayList<Study> studies) {
                mStudyView.showStudy(studies);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Override
    public void start() {

    }

}
