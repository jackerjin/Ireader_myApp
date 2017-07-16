package com.example.tarena.volleytest01.entity;

import java.util.Arrays;

public class WeatherBean {
    private String reason;
    private Result result;
    private int error_code;

    public WeatherBean(String reason, Result result, int error_code) {
        super();
        this.reason = reason;
        this.result = result;
        this.error_code = error_code;
    }

    public WeatherBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "WeatherBean [reason=" + reason + ", result=" + result + ", error_code=" + error_code + "]";
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class Result{
        private Data data;

        public Result(Data data) {
            super();
            this.data = data;
        }
        public Result() {
            super();
            // TODO Auto-generated constructor stub
        }
        @Override
        public String toString() {
            return "Result [data=" + data + "]";
        }
        public Data getData() {
            return data;
        }
        public void setData(Data data) {
            this.data = data;
        }
        public static class Data{
            private String jingqu;
            private String date;
            private String isForeign;
            private Realtime realtime;
            private Life life;
            private PM25 pm25;
            private Weather[] weather;

            public Data(String jingqu, String date, String isForeign, Realtime realtime, Life life, PM25 pm25,
                        Weather[] weather) {
                super();
                this.jingqu = jingqu;
                this.date = date;
                this.isForeign = isForeign;
                this.realtime = realtime;
                this.life = life;
                this.pm25 = pm25;
                this.weather = weather;
            }
            public Data() {
                super();
                // TODO Auto-generated constructor stub
            }
            @Override
            public String toString() {
                return "Data [jingqu=" + jingqu + ", date=" + date + ", isForeign=" + isForeign + ", realtime=" + realtime
                        + ", life=" + life + ", pm25=" + pm25 + ", weather=" + Arrays.toString(weather) + "]";
            }
            public String getJingqu() {
                return jingqu;
            }
            public void setJingqu(String jingqu) {
                this.jingqu = jingqu;
            }
            public String getDate() {
                return date;
            }
            public void setDate(String date) {
                this.date = date;
            }
            public String getIsForeign() {
                return isForeign;
            }
            public void setIsForeign(String isForeign) {
                this.isForeign = isForeign;
            }
            public Realtime getRealtime() {
                return realtime;
            }
            public void setRealtime(Realtime realtime) {
                this.realtime = realtime;
            }
            public Life getLife() {
                return life;
            }
            public void setLife(Life life) {
                this.life = life;
            }
            public PM25 getPm25() {
                return pm25;
            }
            public void setPm25(PM25 pm25) {
                this.pm25 = pm25;
            }
            public Weather[] getWeather() {
                return weather;
            }
            public void setWeather(Weather[] weather) {
                this.weather = weather;
            }
            public static class Life{
                private String date;
                private Info info;

                public Life(String date, Info info) {
                    super();
                    this.date = date;
                    this.info = info;
                }

                public Life() {
                    super();
                    // TODO Auto-generated constructor stub
                }

                @Override
                public String toString() {
                    return "Life [date=" + date + ", info=" + info + "]";
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public Info getInfo() {
                    return info;
                }

                public void setInfo(Info info) {
                    this.info = info;
                }

                public static class Info{
                    private String[] chuanyi;
                    private String[] ganmao;
                    private String[] kongtiao;
                    private String[] wuran;
                    private String[] xiche;
                    private String[] yundong;
                    private String[] ziwaixian;
                    public String[] getChuanyi() {
                        return chuanyi;
                    }
                    public void setChuanyi(String[] chuanyi) {
                        this.chuanyi = chuanyi;
                    }
                    public String[] getGanmao() {
                        return ganmao;
                    }
                    public void setGanmao(String[] ganmao) {
                        this.ganmao = ganmao;
                    }
                    public String[] getKongtiao() {
                        return kongtiao;
                    }
                    public void setKongtiao(String[] kongtiao) {
                        this.kongtiao = kongtiao;
                    }
                    public String[] getWuran() {
                        return wuran;
                    }
                    public void setWuran(String[] wuran) {
                        this.wuran = wuran;
                    }
                    public String[] getXiche() {
                        return xiche;
                    }
                    public void setXiche(String[] xiche) {
                        this.xiche = xiche;
                    }
                    public String[] getYundong() {
                        return yundong;
                    }
                    public void setYundong(String[] yundong) {
                        this.yundong = yundong;
                    }
                    public String[] getZiwaixian() {
                        return ziwaixian;
                    }
                    public void setZiwaixian(String[] ziwaixian) {
                        this.ziwaixian = ziwaixian;
                    }
                    @Override
                    public String toString() {
                        return "Info [chuanyi=" + Arrays.toString(chuanyi) + ", ganmao=" + Arrays.toString(ganmao)
                                + ", kongtiao=" + Arrays.toString(kongtiao) + ", wuran=" + Arrays.toString(wuran)
                                + ", xiche=" + Arrays.toString(xiche) + ", yundong=" + Arrays.toString(yundong)
                                + ", ziwaixian=" + Arrays.toString(ziwaixian) + "]";
                    }
                    public Info() {
                        super();
                        // TODO Auto-generated constructor stub
                    }
                    public Info(String[] chuanyi, String[] ganmao, String[] kongtiao, String[] wuran, String[] xiche,
                                String[] yundong, String[] ziwaixian) {
                        super();
                        this.chuanyi = chuanyi;
                        this.ganmao = ganmao;
                        this.kongtiao = kongtiao;
                        this.wuran = wuran;
                        this.xiche = xiche;
                        this.yundong = yundong;
                        this.ziwaixian = ziwaixian;
                    }



                }
            }
            public static class Realtime{
                private String city_code;
                private String city_name;
                private String date;
                private String time;
                private String moon;
                private long dateUPtime;
                private int week;
                private Wind wind;
                private Weather Weather;

                public Realtime(String city_code, String city_name, String date, String time, String moon, long dateUPtime,
                                int week, Wind wind, com.example.tarena.volleytest01.entity.WeatherBean.Result.Data.Realtime.Weather weather) {
                    super();
                    this.city_code = city_code;
                    this.city_name = city_name;
                    this.date = date;
                    this.time = time;
                    this.moon = moon;
                    this.dateUPtime = dateUPtime;
                    this.week = week;
                    this.wind = wind;
                    Weather = weather;
                }
                public Realtime() {
                    super();
                    // TODO Auto-generated constructor stub
                }
                @Override
                public String toString() {
                    return "Realtime [city_code=" + city_code + ", city_name=" + city_name + ", date=" + date + ", time="
                            + time + ", moon=" + moon + ", dateUPtime=" + dateUPtime + ", week=" + week + ", wind=" + wind
                            + ", Weather=" + Weather + "]";
                }
                public String getCity_code() {
                    return city_code;
                }
                public void setCity_code(String city_code) {
                    this.city_code = city_code;
                }
                public String getCity_name() {
                    return city_name;
                }
                public void setCity_name(String city_name) {
                    this.city_name = city_name;
                }
                public String getDate() {
                    return date;
                }
                public void setDate(String date) {
                    this.date = date;
                }
                public String getTime() {
                    return time;
                }
                public void setTime(String time) {
                    this.time = time;
                }
                public String getMoon() {
                    return moon;
                }
                public void setMoon(String moon) {
                    this.moon = moon;
                }
                public long getDateUPtime() {
                    return dateUPtime;
                }
                public void setDateUPtime(long dateUPtime) {
                    this.dateUPtime = dateUPtime;
                }
                public int getWeek() {
                    return week;
                }
                public void setWeek(int week) {
                    this.week = week;
                }
                public Wind getWind() {
                    return wind;
                }
                public void setWind(Wind wind) {
                    this.wind = wind;
                }
                public Weather getWeather() {
                    return Weather;
                }
                public void setWeather(Weather weather) {
                    Weather = weather;
                }
                public static class Wind{
                    private String direct;
                    private String power;
                    private String offset;
                    private String windspeed;
                    public String getDirect() {
                        return direct;
                    }
                    public void setDirect(String direct) {
                        this.direct = direct;
                    }
                    public String getPower() {
                        return power;
                    }
                    public void setPower(String power) {
                        this.power = power;
                    }
                    public String getOffset() {
                        return offset;
                    }
                    public void setOffset(String offset) {
                        this.offset = offset;
                    }
                    public String getWindspeed() {
                        return windspeed;
                    }
                    public void setWindspeed(String windspeed) {
                        this.windspeed = windspeed;
                    }
                    @Override
                    public String toString() {
                        return "Wind [direct=" + direct + ", power=" + power + ", offset=" + offset + ", windspeed="
                                + windspeed + "]";
                    }
                    public Wind() {
                        super();
                        // TODO Auto-generated constructor stub
                    }
                    public Wind(String direct, String power, String offset, String windspeed) {
                        super();
                        this.direct = direct;
                        this.power = power;
                        this.offset = offset;
                        this.windspeed = windspeed;
                    }

                }
                public static class Weather{
                    private String temperature;
                    private String humidity;
                    private String info;
                    private String img;
                    public String getTemperature() {
                        return temperature;
                    }
                    public void setTemperature(String temperature) {
                        this.temperature = temperature;
                    }
                    public String getHumidity() {
                        return humidity;
                    }
                    public void setHumidity(String humidity) {
                        this.humidity = humidity;
                    }
                    public String getInfo() {
                        return info;
                    }
                    public void setInfo(String info) {
                        this.info = info;
                    }
                    public String getImg() {
                        return img;
                    }
                    public void setImg(String img) {
                        this.img = img;
                    }
                    @Override
                    public String toString() {
                        return "Weather [temperature=" + temperature + ", humidity=" + humidity + ", info=" + info
                                + ", img=" + img + "]";
                    }
                    public Weather() {
                        super();
                        // TODO Auto-generated constructor stub
                    }
                    public Weather(String temperature, String humidity, String info, String img) {
                        super();
                        this.temperature = temperature;
                        this.humidity = humidity;
                        this.info = info;
                        this.img = img;
                    }

                }
            }

        }

        public static class PM25{
            private String key;
            private String dateTime;
            private String cityName;
            private int show_desc;
            private Pm25 pm25;

            public PM25(String key, String dateTime, String cityName, int show_desc, Pm25 pm25) {
                super();
                this.key = key;
                this.dateTime = dateTime;
                this.cityName = cityName;
                this.show_desc = show_desc;
                this.pm25 = pm25;
            }

            public PM25() {
                super();
                // TODO Auto-generated constructor stub
            }

            @Override
            public String toString() {
                return "PM25 [key=" + key + ", dateTime=" + dateTime + ", cityName=" + cityName + ", show_desc="
                        + show_desc + ", pm25=" + pm25 + "]";
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getDateTime() {
                return dateTime;
            }

            public void setDateTime(String dateTime) {
                this.dateTime = dateTime;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public int getShow_desc() {
                return show_desc;
            }

            public void setShow_desc(int show_desc) {
                this.show_desc = show_desc;
            }

            public Pm25 getPm25() {
                return pm25;
            }

            public void setPm25(Pm25 pm25) {
                this.pm25 = pm25;
            }

            public static class Pm25{
                private String curPm;
                private String pm25;
                private String pm10;
                private String quality;
                private String des;
                private int level;
                public String getCurPm() {
                    return curPm;
                }
                public void setCurPm(String curPm) {
                    this.curPm = curPm;
                }
                public String getPm25() {
                    return pm25;
                }
                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }
                public String getPm10() {
                    return pm10;
                }
                public void setPm10(String pm10) {
                    this.pm10 = pm10;
                }
                public String getQuality() {
                    return quality;
                }
                public void setQuality(String quality) {
                    this.quality = quality;
                }
                public String getDes() {
                    return des;
                }
                public void setDes(String des) {
                    this.des = des;
                }
                public int getLevel() {
                    return level;
                }
                public void setLevel(int level) {
                    this.level = level;
                }
                @Override
                public String toString() {
                    return "Pm25 [curPm=" + curPm + ", pm25=" + pm25 + ", pm10=" + pm10 + ", quality=" + quality
                            + ", des=" + des + ", level=" + level + "]";
                }
                public Pm25(String curPm, String pm25, String pm10, String quality, String des, int level) {
                    super();
                    this.curPm = curPm;
                    this.pm25 = pm25;
                    this.pm10 = pm10;
                    this.quality = quality;
                    this.des = des;
                    this.level = level;
                }
                public Pm25() {
                    super();
                    // TODO Auto-generated constructor stub
                }

            }
        }
        public static class Weather{
            private String week;
            private String date;
            private String nongli;
            private Info info;

            public Weather(String week, String date, String nongli, Info info) {
                super();
                this.week = week;
                this.date = date;
                this.nongli = nongli;
                this.info = info;
            }

            public Weather() {
                super();
                // TODO Auto-generated constructor stub
            }

            @Override
            public String toString() {
                return "Weather [week=" + week + ", date=" + date + ", nongli=" + nongli + ", info=" + info + "]";
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getNongli() {
                return nongli;
            }

            public void setNongli(String nongli) {
                this.nongli = nongli;
            }

            public Info getInfo() {
                return info;
            }

            public void setInfo(Info info) {
                this.info = info;
            }

            public static class Info{
                private String[] day;
                private String[] night;
                private String[] down;
                public String[] getDay() {
                    return day;
                }
                public void setDay(String[] day) {
                    this.day = day;
                }
                public String[] getNight() {
                    return night;
                }
                public void setNight(String[] night) {
                    this.night = night;
                }
                public String[] getDown() {
                    return down;
                }
                public void setDown(String[] down) {
                    this.down = down;
                }
                @Override
                public String toString() {
                    return "Info [day=" + Arrays.toString(day) + ", night=" + Arrays.toString(night) + ", down="
                            + Arrays.toString(down) + "]";
                }
                public Info() {
                    super();
                    // TODO Auto-generated constructor stub
                }
                public Info(String[] day, String[] night, String[] down) {
                    super();
                    this.day = day;
                    this.night = night;
                    this.down = down;
                }



            }
        }
    }
}
