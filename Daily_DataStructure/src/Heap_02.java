import java.util.*;

public class Heap_02 {
    static class Job implements Comparable<Job>{
        int request;
        int jobTime;

        public Job(int request, int jobTime) {
            this.request = request;
            this.jobTime = jobTime;
        }
        @Override
        public int compareTo(Job o) {
            return this.jobTime - o.jobTime;
        }
    }
    public static int solution(int[][] jobs) {
        ArrayList <Job> jobList = new ArrayList<>();
        PriorityQueue <Job> waitingQueue = new PriorityQueue<>();

        Arrays.sort(jobs, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return Integer.compare(o1[1] , o2[1]);
            } else{
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for (int i = 0; i < jobs.length; i++) {
            jobList.add(new Job(jobs[i][0], jobs[i][1]));
        }
        int prev_finish = 0;
        int answer = 0;

        while(!jobList.isEmpty() || !waitingQueue.isEmpty()){
            boolean isNew = false;

            Iterator <Job> iter = jobList.iterator();
            while(iter.hasNext()) {
                Job job = iter.next();
                if (job.request > prev_finish) break;

                waitingQueue.add(job);
                iter.remove();
            }
                if(waitingQueue.size() == 0){
                    waitingQueue.add(jobList.get(0));
                    jobList.remove(0);

                    isNew = true;
                }

                Job wJob = waitingQueue.poll();
                if(isNew){
                    answer += wJob.jobTime;
                    prev_finish = wJob.request + wJob.jobTime;
                } else{
                    answer += ((prev_finish - wJob.request) + wJob.jobTime);
                    prev_finish += wJob.jobTime;
                }
            }
        return (int)(answer / jobs.length);

    }
    public static void main(String args[]){
       int [][]arr = {{0,3},{1,9},{2,6}};
       // int [][]arr = {{7,8},{3,5},{9,6}};
        System.out.println(solution(arr));
    }
}
