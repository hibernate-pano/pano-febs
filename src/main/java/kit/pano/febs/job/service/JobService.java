package kit.pano.febs.job.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import kit.pano.febs.common.domain.QueryRequest;
import kit.pano.febs.job.domain.Job;


public interface JobService extends IService<Job> {

    Job findJob(Long jobId);

    IPage<Job> findJobs(QueryRequest request, Job job);

    void createJob(Job job);

    void updateJob(Job job);

    void deleteJobs(String[] jobIds);

    int updateBatch(String jobIds, String status);

    void run(String jobIds);

    void pause(String jobIds);

    void resume(String jobIds);

}
