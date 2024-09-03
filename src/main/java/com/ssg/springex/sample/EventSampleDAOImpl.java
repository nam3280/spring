package com.ssg.springex.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Qualifier("event")
@Repository
public class EventSampleDAOImpl implements SampleDAO {
}