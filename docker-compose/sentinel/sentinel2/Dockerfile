FROM redis:5.0.9
ADD ./sentinel.conf /redis/sentinel.conf
CMD ["redis-sentinel", "/redis/sentinel.conf"]
