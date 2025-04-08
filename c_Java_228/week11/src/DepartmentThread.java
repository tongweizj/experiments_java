public class DepartmentThread extends Thread {
    private final String departmentName;

    public DepartmentThread(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public void run() {
        try {
            // any operations thread is supposed to do
            System.out.println(departmentName + "department started attending visitors" +
            " Priority :" + Thread.currentThread().getPriority());
            for (int i = 1; i < 5; i++) {
                System.out.println(departmentName + " starting tour" + i);
                Thread.sleep(2000); // 人为制作进程中断
            }
            System.out.println(departmentName + " department completed open house sessions");
        } catch (InterruptedException ex) {
//            throw new RuntimeException(e);
            System.out.println(departmentName + " interrupted." + ex);
        } catch (Exception ex){
            System.out.println("Something went wrong while executing " +
                    departmentName + "thread： " + ex);
        }
    }
}
