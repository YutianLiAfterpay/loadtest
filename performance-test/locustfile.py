from locust import HttpLocust, TaskSet, task, seq_task


class InboundRequest(TaskSet):
    def on_start(self):
        """ on_start is called when a Locust start before any task is
        scheduled """

    def on_stop(self):
        """ on_stop is called when the TaskSet is stopping """

    @task
    @seq_task(1)
    def hello(self):
        self.client.get("/hello")


class ServiceUser(HttpLocust):
    task_set = InboundRequest
