/*
 * JAVE - A Java Audio/Video Encoder (based on FFMPEG)
 * 
 * Copyright (C) 2008-2009 Carlo Pelliccia (www.sauronsoftware.it)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ws.schild.jave;

import java.io.Serializable;

/**
 * Attributes controlling the audio encoding process.
 *
 * @author Carlo Pelliccia
 */
public class AudioAttributes implements Serializable {

    private static final long serialVersionUID = 2L;

    /**
     * This value can be setted in the codec field to perform a direct stream
     * copy, without re-encoding of the audio stream.
     */
    public static final String DIRECT_STREAM_COPY = "copy";

    /**
     * The codec name for the encoding process. If null or not specified the
     * encoder will perform a direct stream copy.
     */
    private String codec = null;

    /**
     * The bitrate value for the encoding process. If null or not specified a
     * default value will be picked.
     */
    private Integer bitRate = null;

    /**
     * The samplingRate value for the encoding process. If null or not specified
     * a default value will be picked.
     */
    private Integer samplingRate = null;

    /**
     * The channels value (1=mono, 2=stereo) for the encoding process. If null
     * or not specified a default value will be picked.
     */
    private Integer channels = null;

    /**
     * The volume value for the encoding process. If null or not specified a
     * default value will be picked. If 256 no volume change will be performed.
     */
    private Integer volume = null;

    /**
     * The audio quality value for the encoding process. If null or not specified
     * the ffmpeg default will be used
     */
    private Integer quality = null;
    
    /**
     * Returns the codec name for the encoding process.
     *
     * @return The codec name for the encoding process.
     */
    String getCodec() {
        return codec;
    }

    /**
     * Sets the codec name for the encoding process. If null or not specified
     * the encoder will perform a direct stream copy.
     *
     * Be sure the supplied codec name is in the list returned by
     * {@link Encoder#getAudioEncoders()}.
     *
     * A special value can be picked from
     * {@link AudioAttributes#DIRECT_STREAM_COPY}.
     *
     * @param codec The codec name for the encoding process.
     */
    public void setCodec(String codec) {
        this.codec = codec;
    }

    /**
     * Returns the bitrate value for the encoding process.
     *
     * @return The bitrate value for the encoding process.
     */
    Integer getBitRate() {
        return bitRate;
    }

    /**
     * Sets the bitrate value for the encoding process. If null or not specified
     * a default value will be picked.
     *
     * @param bitRate The bitrate value for the encoding process.
     */
    public void setBitRate(Integer bitRate) {
        this.bitRate = bitRate;
    }

    /**
     * Returns the samplingRate value for the encoding process.
     *
     * @return the samplingRate The samplingRate value for the encoding process.
     */
    Integer getSamplingRate() {
        return samplingRate;
    }

    /**
     * Sets the samplingRate value for the encoding process. If null or not
     * specified a default value will be picked.
     *
     * @param samplingRate The samplingRate value for the encoding process.
     */
    public void setSamplingRate(Integer samplingRate) {
        this.samplingRate = samplingRate;
    }

    /**
     * Returns the channels value (1=mono, 2=stereo, 4=quad) for the encoding process.
     *
     * @return The channels value (1=mono, 2=stereo, 4=quad) for the encoding process.
     */
    Integer getChannels() {
        return channels;
    }

    /**
     * Sets the channels value (1=mono, 2=stereo, 4=quad) for the encoding process. If
     * null or not specified a default value will be picked.
     *
     * @param channels The channels value (1=mono, 2=stereo, 4=quad) for the encoding
     * process.
     */
    public void setChannels(Integer channels) {
        this.channels = channels;
    }

    /**
     * Returns the volume value for the encoding process.
     *
     * @return The volume value for the encoding process.
     */
    Integer getVolume() {
        return volume;
    }

    /**
     * Sets the volume value for the encoding process. If null or not specified
     * a default value will be picked. If 256 no volume change will be
     * performed.
     * 
     * volume is the "amplitude ratio" or "sound pressure level" ratio
     * 2560 is volume=20dB
     * The formula is dBnumber=20*lg(amplitude ratio)
     * 128 means reducing by 50%
     * 512 means doubling the volume
     * 
     * @param volume The volume value for the encoding process.
     */
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    /**
     * @return the audio conversion quality
     */
    public Integer getQuality() {
        return quality;
    }

    /**
     * The audio quality value for the encoding process. If null or not specified
     * the ffmpeg default will be used
     * 
     * The value depends on the choosen codec
     * 
     * For mp3 you can see here:
     * https://trac.ffmpeg.org/wiki/Encode/MP3
     * 
     * Or more general
     * https://ffmpeg.org/ffmpeg-codecs.html
     * 
     * @param quality the audio conversion quality to set
     */
    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return getClass().getName() + "(codec=" + codec + ", bitRate="
                + bitRate + ", samplingRate=" + samplingRate + ", channels="
                + channels + ", volume=" + volume + ", quality="+quality+ ")";
    }
}
