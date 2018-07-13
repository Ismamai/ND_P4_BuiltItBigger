package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;

@RunWith(AndroidJUnit4.class)
public class EndpointAsyncTaskTest {
    final CountDownLatch signal = new CountDownLatch(1);

    @Test
    public void testAsyncTask() throws InterruptedException {
        final EndpointsAsyncTask task = new EndpointsAsyncTask() {
            @Override
            protected String doInBackground(Void... voids) {
                return super.doInBackground(voids);
            }

            @Override
            protected void onPostExecute(String joke) {
                Assert.assertThat(joke, is(not(IsNull.nullValue())));
                Assert.assertThat(joke, is(not("")));
                signal.countDown();
            }
        };

        task.execute();

        signal.await(25, TimeUnit.SECONDS);

    }
}
