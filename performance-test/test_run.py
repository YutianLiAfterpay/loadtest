import invokust


def test_response():
    assert response['num_requests'] > 300
    assert len(response['failures']) == 0
    assert response['num_requests_fail'] == 0


settings = invokust.create_settings(
    locustfile='locustfile.py',
    host='http://localhost:8082',
    num_clients=1000,
    hatch_rate=100,
    run_time='3s'
)

load_test = invokust.LocustLoadTest(settings)
load_test.run()
response = load_test.stats()

test_response()
