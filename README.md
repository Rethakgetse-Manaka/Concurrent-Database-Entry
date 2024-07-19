### Project Description

**Simulated Security Protocol with Centralized Job Scheduling**

This project involves creating a simulated security protocol that leverages a central database to manage and schedule jobs within a system. The simulation includes two distinct user types, each with specific roles and authorization levels:

1. **Developer**:
   - Tasked with scheduling necessary jobs.
   - Job requests are inserted into a central database.
   - Each job requires a randomly generated number of hours (between 1 and 24) to complete.

2. **System Administrator**:
   - Reviews the job schedule created by developers and either approves or disapproves the jobs.
   - Job requests are removed from the central database.
   - Jobs are approved if the required hours are less than a randomly generated number (between 1 and 24).

### Concurrency and Threads:
The project demonstrates concurrency using a variable number of threads, ideally maintaining a ratio of 2 System Administrators to 4 Developers. Each developer is required to schedule at least three jobs.

### Expected Output:
1. **Insertion**: Demonstrate job scheduling with the format `(IN) [thread-name] [job-number] [hours]`.
2. **Removal**: Demonstrate job approval/disapproval with the format `(OUT) [thread-name] [job-number] [hours] [approval-status]`.

### Tasks:
1. **Task 1 - Lock-free Queue**:
   - Implement an unbounded lock-free queue as the central database for job scheduling.

2. **Task 2 - Lock-free Stack**:
   - Implement a lock-free stack as the central database for job scheduling.

This project effectively simulates a security protocol, showcasing concurrency, job scheduling, and approval processes within a multi-threaded environment. It highlights the practical application of lock-free data structures in managing concurrent tasks efficiently.
