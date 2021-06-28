package com.ykq.bridge.demo2;

import com.ykq.bridge.demo2.course.ICourse;
import com.ykq.bridge.demo2.resource.INote;
import com.ykq.bridge.demo2.resource.IVideo;

/**
 * @Date 2021/03/26
 * @Version v1.0.0
 */
public class CourseBridge implements ICourse {
    private INote note;
    private IVideo video;

    public CourseBridge(INote note, IVideo video) {
        this.note = note;
        this.video = video;
    }
}
